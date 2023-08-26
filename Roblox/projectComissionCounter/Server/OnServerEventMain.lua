local userAbility=require(game.ReplicatedStorage.WhatPlayerCanDO)

local ReplicatedStorage = game:GetService("ReplicatedStorage")
local remoteEventPointGiver = ReplicatedStorage:WaitForChild("pointGiver")
local remoteEventGamepassPointGiver = ReplicatedStorage:WaitForChild("gamepassPointGiver")
local SaveModule=require(game.ServerScriptService.ServerOnlyModule)

remoteEventPointGiver.OnServerEvent:Connect(function(player, itemPrice)
	userAbility.givePoints(player, itemPrice)
	SaveModule.savePoint(player)
end)

remoteEventGamepassPointGiver.OnServerEvent:Connect(function(player, itemPrice)
	userAbility.giveGamepassPoints(player, itemPrice)
	SaveModule.savePoint(player)
end)