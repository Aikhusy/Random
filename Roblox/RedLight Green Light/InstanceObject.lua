local entity = {}

local path= game:GetService("ReplicatedStorage").TheCreature.Asset



function entity.create()
	local newEntity=path:Clone()
	newEntity.Parent= game:GetService('StarterGui')
	
	newEntity:Destroy()
end


function entity.behaviour(Player)
	local pos=Player.position
	
	wait(1)
	
	local newPos = Player.position
	
	if pos ~= newPos then
		local playerCurentHealth=Player:FindFirstChild("Humanoid").Health
		Player:FindFirstChild("Humanoid").Health=playerCurentHealth-40
	end
 
end

return entity