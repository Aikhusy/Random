local light= game:GetService("Lighting")

local GAME_STATUS = false

local START_TIME = 17

local TIME_SPEED = 120 

local TRIGGER_STOP = 18 

local minutesAfterMidnight = START_TIME * 60

local waitTime = 60 / TIME_SPEED

local function timerStart ()

    while true do

        print(minutesAfterMidnight)

        minutesAfterMidnight = minutesAfterMidnight + 1

        light:SetMinutesAfterMidnight(minutesAfterMidnight)

        task.wait(waitTime)

        if TRIGGER_STOP * 60 == minutesAfterMidnight then

            break

        end

    end

end

local function statusCheck()

    if (GAME_STATUS) then

        timerStart()

        GAME_STATUS=false

    end

end

local function index()

    statusCheck()

end


GAME_STATUS=true

index()