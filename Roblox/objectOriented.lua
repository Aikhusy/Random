local Door = {}

function Door.create(position,name)
	local newDoor = game.Workspace.EsentialAsset.Door:Clone()
	newDoor.Name = name
	newDoor.Parent = game.Workspace.MainMap.Rooms
	newDoor.PrimaryPart.CFrame = CFrame.new(position)
end

function Door.getCurrentRoom()
	local folder=game.Workspace.MainMap.Rooms
	local number=0
	for _, child in ipairs(folder:GetChildren()) do
		
		number+=1
	end
	return number
end

function Door.setNewPosition(oldPosition)
	local room= Door.getCurrentRoom()
	
	local newPosition=Vector3.new(oldPosition.X,oldPosition.Y,oldPosition.Z*room)
	return newPosition
end
return Door
