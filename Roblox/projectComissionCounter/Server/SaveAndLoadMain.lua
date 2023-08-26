local user = {}

local Players=game:GetService("Players")
local DataStore=game:GetService("DataStoreService")
local CashbackDataStore = DataStore:GetDataStore("Cashback")

local market=game:GetService("MarketplaceService")
local remoteEventPointGiver=game:GetService("ReplicatedStorage").pointGiver

function user.loadPoint(player, atribut)
	local userId = player.UserId
	local data
	local success, errormessage = pcall(function()
		data = CashbackDataStore:GetAsync(userId)
	end)

	if success then
		atribut.Value = data or 0
	else
		print("Error loading points:", errormessage)
	end
end

function user.createPoint(player)

	
	local leaderstats= Instance.new("Folder")
	leaderstats.Name="leaderstats"
	leaderstats.Parent=player


	local coins = Instance.new("IntValue")
	coins.Name="Cashback"
	coins.Parent=leaderstats


	user.loadPoint(player,coins)


end

function user.savePoint(player)

	local userId= player.UserId

	local data=player.leaderstats.Cashback.Value
	print("savepoint telah berjalan")
	print(data)
	print(userId)
	local success, error = pcall(function()
		CashbackDataStore:SetAsync(userId,tonumber(data) )
	end)

	if success then
		print("Savepoint successful.")
	else
		print("Error saving point:", error)
	end
end

return user
