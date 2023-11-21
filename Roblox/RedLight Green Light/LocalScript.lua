local ReplicatedStorage = game:GetService("ReplicatedStorage")
local GiveDamage = ReplicatedStorage:WaitForChild("GiveDamage")
local deletePart = ReplicatedStorage:WaitForChild("DeleteEntity")
local SG=game:GetService("StarterGui")
local debounce=false
local players= game:GetService('Players').LocalPlayer

local function animate(Player,time)
	local warning = Player.PlayerGui.A90.Warning
	local stop = Player.PlayerGui.A90.Stop
	warning.Visible = true

	local randomNumber = math.random(1, 3)
	wait(time)
	warning.Visible = false
	stop.Visible = true
	local currentPos=Player.Character:WaitForChild("HumanoidRootPart").Position
	wait(0.9)

	warning.Visible = false
	stop.Visible = false
	return currentPos
end

local function RandomSpawn(number)
	if debounce==false then
		debounce=true
		deletePart:FireServer(part)
		local currentPos=animate(players,number)
		local newPos=players.Character:WaitForChild("HumanoidRootPart").Position
		if currentPos ~= newPos then
			GiveDamage:FireServer(players)
			print('You Moved')
		end
		print("GoodJob")

		wait(2)
		debounce= false	
	end
end

game:GetService('ReplicatedStorage').SpawnA90.OnClientEvent:Connect(RandomSpawn)

