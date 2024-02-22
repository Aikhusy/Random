local folder = game.Workspace.Entities 


local function CountObjectsInFolder(folder)
	local count = 0
	for _, child in ipairs(folder:GetChildren()) do
		count = count + 1
	end
	return count
end


local function CheckObjectCountAndFireEvents()
	local objectCount = CountObjectsInFolder(folder)
	print(objectCount)
	local whiteEvent = game.ReplicatedStorage:WaitForChild('Events'):WaitForChild('Radio'):FindFirstChild('TurnWhite')
	local redEvent = game.ReplicatedStorage:WaitForChild('Events'):WaitForChild('Radio'):FindFirstChild('TurnRed')

	if objectCount>=1 then
		-- Turn red
		print("red")
		redEvent:FireAllClients()
	else
		-- Turn white
		print("white")
		whiteEvent:FireAllClients()
	end
end

-- loop trigger
while true do
	print("getting values")
	CheckObjectCountAndFireEvents()
	wait(5) 
end
