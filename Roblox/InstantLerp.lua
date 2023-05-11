local module = {}

-- Module Script To move object without tween service
-- if you want to move an object and adding if touch code
-- use this code instead of tween service

local runService=game:GetService("RunService")

function module.moveTo(part,startPosition,endPosition,lerpTime)
	local runningTime=0
	local lerp
	
	lerp= runService.Heartbeat:Connect(function(deltaTime)
		runningTime+=deltaTime
		local alpha= runningTime/lerpTime
		part.CFrame= startPosition:Lerp(endPosition,alpha)
		
		if alpha>=1 then
			lerp:Disconnect()
		end
	end)
end

return module

--Code Example To Use 

--local module=require(game.Workspace.ModuleScript)

--local part= game.Workspace.Part
--local moveto=CFrame.new(60,40,0)
--print(part.CFrame)
--print(part.CFrame*moveto)

--module.moveTo(part,part.CFrame,part.CFrame*moveto,10)
