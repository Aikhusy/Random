game.Players.PlayerAdded:Connect(function(player)
	
	local status=Instance.new("Folder",player)
	status.Name="leaderstats"
	
	local Gold=Instance.new("IntValue",status)
	Gold.Name="Pembelian"
	
	Gold.Value=0
	
end)