local RS= game:GetService("ReplicatedStorage")
local debounce=false
local time=10

RS.GiveDamage.OnServerEvent:Connect(function(player)
	local newHealth= player.Character:FindFirstChildOfClass("Humanoid").Health - 40
	player.Character:FindFirstChildOfClass("Humanoid").Health=newHealth
end)

RS.InstanceA90.OnServerEvent:Connect(function(player)
	local newInstance=RS.A90:Clone()
	newInstance.Parent=workspace
	newInstance.Name="A90"
end)

RS.DeleteEntity.OnServerEvent:Connect(function(player,part)
	part:Destroy()
end)

RS.SpawnA90.OnServerEvent:Connect(function(player)
	return math.random(1, 3)
end)

local function giveTime()
		local randomNumber = math.random(1, 5) -- Generate a random number between 1 and 100 (modify range as needed)
		game:GetService("ReplicatedStorage").SpawnA90:FireAllClients(randomNumber)-- Fire the event to all clients (players)
end

while true do
	wait (4)
	giveTime()
end