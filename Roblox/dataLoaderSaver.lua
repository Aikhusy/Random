local DataStore = game:GetService("DataStoreService")
local pembelian = DataStore:GetDataStore("Cashback")

game.Players.PlayerAdded:Connect(function(player)
	local leaderstats= Instance.new("Folder")
	leaderstats.Name="leaderstats"
	leaderstats.Parent=player
	
	local coins = Instance.new("IntValue")
	coins.Name="Cashback"
	coins.Parent=leaderstats
	
	local userId= player.UserId
	local data
	local success, errormessage = pcall(function()
		data= pembelian:GetAsync(userId)
	end)
	
	if success then
		coins.Value=data
	end
end)

game.Players.PlayerRemoving:Connect(function(player)
	local userId= player.UserId
	
	local data=player.leaderstats.Cashback.Value
	
	pembelian:SetAsync(userId, data)
end)
