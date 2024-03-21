local a=5231339475
local method=require(game:GetService('ReplicatedStorage').WhatPlayerCanDO)
local marketplaceService = game:GetService("MarketplaceService")
local RemoteEvent = game:GetService("ReplicatedStorage"):WaitForChild("APIRemote") -- Sesuaikan dengan nama RemoteEvent yang Anda buat

-- Fungsi untuk mengirim pesan ke server dengan harga item
local function SendMessageToServer(assetId, priceInRobux)
	RemoteEvent:FireServer(assetId, priceInRobux)
end

local function onPromptPurchaseFinished(player, assetId, isPurchased)
	if isPurchased then
		-- Jika pembelian berhasil, ambil harga item dari Roblox Marketplace
		local productInfo = marketplaceService:GetProductInfo(assetId, Enum.InfoType.Bundle)
		if productInfo then
			local priceInRobux = math.floor(productInfo.PriceInRobux * 0.4)

			SendMessageToServer(priceInRobux)
			print("Harga item dengan ID", assetId, "adalah", priceInRobux, "Robux.")
		else
			warn("Gagal mendapatkan informasi produk untuk ID item:", assetId)
		end
	else
		print(player.Name, "tidak membeli item dengan AssetID:", assetId)
	end
end

game:GetService("MarketplaceService").PromptBundlePurchaseFinished:Connect(onPromptPurchaseFinished)

script.Parent.FocusLost:Connect(function(enter)
	a=tonumber(script.Parent.Text)
	print(a)
	print(game.Players.LocalPlayer)
	method.buyBundle(game.Players.LocalPlayer,a)

end)

