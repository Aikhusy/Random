local user = {}

local Players=game:GetService("Players")
local market=game:GetService("MarketplaceService")
local remoteEventPointGiver=game:GetService("ReplicatedStorage").pointGiver
local remoteEventGamepassPointGiver=game:GetService("ReplicatedStorage").gamepassPointGiver

function user.getCurrentPoint(player)
	local point = player.leaderstats.Cashback.Value
	return point
end


function user.givePoints(player,amount)
	local username= player.Name
	local curentPoint=user.getCurrentPoint(player)
	print(curentPoint)
	print(amount)
	local newpoint=user.getCurrentPoint(player)+(amount*40/100)
	
	player.leaderstats.Cashback.Value=newpoint
end

function user.giveGamepassPoints(player,amount)
	local username= player.Name
	local curentPoint=user.getCurrentPoint(player)
	print(curentPoint)
	print(amount)
	local newpoint=user.getCurrentPoint(player)+(amount*10/100)

	player.leaderstats.Cashback.Value=newpoint
end

function user.buyAccessories(player,itemId)
	market:PromptPurchase(player,itemId)
	
	market.PromptPurchaseFinished:Connect(function(player, purchaseId, wasPurchased)
		if wasPurchased then
			local productInfo=market:GetProductInfo(itemId)
			
			remoteEventPointGiver:FireServer(productInfo.PriceInRobux)
			print("telah bekerja bagian fire server")
		end
	end)
end

function user.buyBundle(player,itemId)
	print(itemId)
	print(player.Name)
	
	game:GetService("MarketplaceService"):PromptBundlePurchase(game.Players.LocalPlayer,itemId)
	print("Prompt jalan")
	market.PromptBundlePurchaseFinished:Connect(function(player, itemId, wasPurchased)
		if wasPurchased then
			local test=652
			local productInfo = market:GetProductInfo(test, Enum.InfoType.Bundle)
			print(productInfo)
			remoteEventPointGiver:FireServer(tonumber(productInfo.PriceInRobux))
			print("telah bekerja bagian fire server")
		end
	end)
end

function user.buyGamePass(player,itemId)
	market:PromptGamePassPurchase(player,itemId)

	market.PromptGamePassPurchaseFinished:Connect(function(player, itemId, wasPurchased)
		if wasPurchased then
			local productInfo=market:GetProductInfo(itemId, Enum.InfoType.GamePass)
			print(productInfo.PriceInRobux)
			
			remoteEventGamepassPointGiver:FireServer(productInfo.PriceInRobux)
			print("telah bekerja bagian fire server")
		end
	end)
end

return user
