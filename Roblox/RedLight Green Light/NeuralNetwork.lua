local ReplicatedStorage = game:GetService("ReplicatedStorage")
local GiveDamage = ReplicatedStorage:WaitForChild("GiveDamage")
local deletePart = ReplicatedStorage:WaitForChild("DeleteEntity")
local SG=game:GetService("StarterGui")
local debounce=false
local players= game:GetService('Players').LocalPlayer

local function