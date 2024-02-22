whiteEvent= game.ReplicatedStorage.Events.Radio.TurnWhite

whiteEvent.OnClientEvent:Connect(function()
	--change the color to white
	print("white")
	workspace.Testing.TestBlock.BrickColor=BrickColor.new(255, 255, 255)
end)

redEvent= game.ReplicatedStorage.Events.Radio.TurnRed

redEvent.OnClientEvent:Connect(function()
	--change the color to white
	print("red")
	workspace.Testing.TestBlock.BrickColor=BrickColor.new(255, 0, 0)
end)