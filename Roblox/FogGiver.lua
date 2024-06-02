local Lighting = game:GetService("Lighting")
local Atmosphere = Lighting:WaitForChild("Atmosphere")

local density = Atmosphere.Density --floating number

local offset = Atmosphere.Offset --floating number

local color = Atmosphere.Color --color

local decay = Atmosphere.Decay --color

local glare = Atmosphere.Glare --floating number

local haze = Atmosphere.Haze -- floating number

local function setAtmosphereAttribute (dst,ofst,clr,dcy,glr,hz)

    Atmosphere.Density = dst

    Atmosphere.Offset = ofst

    Atmosphere.Color = clr

    Atmosphere.Decay = dcy

    Atmosphere.Glare = glr

    Atmosphere.Haze = hz

end

local function clearWeather()

    setAtmosphereAttribute(0, 0, Color3.new(0, 0, 0), Color3.new(0, 0, 0), 0, 0)
    print("Clear")

end

local function bloodyWeather()

    setAtmosphereAttribute(0.642, 0.185, Color3.new(255, 0, 0), Color3.new(170, 0, 0), 4.35, 6.29)
    print("Bloody")

end

local function foggyWeather()

    setAtmosphereAttribute(0.642, 0.185, Color3.new(255, 255, 255), Color3.new(170, 170, 170), 4.35, 6.29)
    print("Foggy")

end

--============================================

--ADD NEW WEATHER HERE
--============================================
--local function newWeather()

--    setAtmosphereAttribute()

--end



local function index()

    --while true do

    --    foggyWeather()
    --    wait(5)
    --    clearWeather()
    --    wait(5)
    --    bloodyWeather()
    --    wait(5)
    --    clearWeather()
    --    wait(5)

    --end
    wait(10)
    bloodyWeather()
    wait(5)
    clearWeather()

end