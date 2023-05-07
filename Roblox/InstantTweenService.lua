local module = {}
-- made by Aikhusy --
-- program for calling tween service with diffrent kind of animation in roblox--
-- You can use this by adding module script and link the script using require(<<path>>)--
local tweenService= game:GetService("TweenService")

function module.propertyLibrary(NEW_POSITION,NEW_SIZE,NEW_COLOR,NEW_TRANSPARENCY)
	--you can add more property here--
	local newPart=
		{
			Position=NEW_POSITION,
			Size=NEW_SIZE,
			Color=NEW_COLOR,
			Transparency=NEW_TRANSPARENCY
		}
	return newPart
end

--return the easing direction from number to Enum--
function easingDirect(EASING_DIRECTION)
	if	EASING_DIRECTION==1 then
		return Enum.EasingDirection.In
	end
	if	EASING_DIRECTION==0 then
		return Enum.EasingDirection.Out
	end
	if EASING_DIRECTION==2 then
		return Enum.EasingDirection.InOut
	end
	return
end

--im trying to make a function for default settings--
function default(TIME_ANIMATION,DIRECTION,REPEAT_TIME,IS_REVERSE,DELAY_TIME,PROPERTY)
	if TIME_ANIMATION==nil then
		
	end
end

--tween Service Mode--
function module.bounce(PART,TIME_ANIMATION,DIRECTION,REPEAT_TIME,IS_REVERSE,DELAY_TIME,PROPERTY)
	local ease=easingDirect(DIRECTION)
	local info= TweenInfo.new(TIME_ANIMATION,Enum.EasingStyle.Bounce,ease,REPEAT_TIME,IS_REVERSE,DELAY_TIME)
	local tween=tweenService:Create(PART,info,PROPERTY)
	
	tween:Play()
end

function module.elastic(PART,TIME_ANIMATION,DIRECTION,REPEAT_TIME,IS_REVERSE,DELAY_TIME,PROPERTY)

	local ease=easingDirect(DIRECTION)
	local info= TweenInfo.new(TIME_ANIMATION,Enum.EasingStyle.Elastic,ease,REPEAT_TIME,IS_REVERSE,DELAY_TIME)
	local tween=tweenService:Create(PART,info,PROPERTY)

	tween:Play()
end

function module.back(PART,TIME_ANIMATION,DIRECTION,REPEAT_TIME,IS_REVERSE,DELAY_TIME,PROPERTY)

	local ease=easingDirect(DIRECTION)
	local info= TweenInfo.new(TIME_ANIMATION,Enum.EasingStyle.Back,ease,REPEAT_TIME,IS_REVERSE,DELAY_TIME)
	local tween=tweenService:Create(PART,info,PROPERTY)

	tween:Play()
end

function module.quad(PART,TIME_ANIMATION,DIRECTION,REPEAT_TIME,IS_REVERSE,DELAY_TIME,PROPERTY)
	
	local ease=easingDirect(DIRECTION)
	local info= TweenInfo.new(TIME_ANIMATION,Enum.EasingStyle.Quad,ease,REPEAT_TIME,IS_REVERSE,DELAY_TIME)
	local tween=tweenService:Create(PART,info,PROPERTY)

	tween:Play()
end

function module.sine(PART,TIME_ANIMATION,DIRECTION,REPEAT_TIME,IS_REVERSE,DELAY_TIME,PROPERTY)

	local ease=easingDirect(DIRECTION)
	local info= TweenInfo.new(TIME_ANIMATION,Enum.EasingStyle.Sine,ease,REPEAT_TIME,IS_REVERSE,DELAY_TIME)
	local tween=tweenService:Create(PART,info,PROPERTY)

	tween:Play()
end

function module.cubic(PART,TIME_ANIMATION,DIRECTION,REPEAT_TIME,IS_REVERSE,DELAY_TIME,PROPERTY)

	local ease=easingDirect(DIRECTION)
	local info= TweenInfo.new(TIME_ANIMATION,Enum.EasingStyle.Cubic,ease,REPEAT_TIME,IS_REVERSE,DELAY_TIME)
	local tween=tweenService:Create(PART,info,PROPERTY)

	tween:Play()
end

function module.quint(PART,TIME_ANIMATION,DIRECTION,REPEAT_TIME,IS_REVERSE,DELAY_TIME,PROPERTY)

	local ease=easingDirect(DIRECTION)
	local info= TweenInfo.new(TIME_ANIMATION,Enum.EasingStyle.Quint,ease,REPEAT_TIME,IS_REVERSE,DELAY_TIME)
	local tween=tweenService:Create(PART,info,PROPERTY)

	tween:Play()
end

function module.quart(PART,TIME_ANIMATION,DIRECTION,REPEAT_TIME,IS_REVERSE,DELAY_TIME,PROPERTY)

	local ease=easingDirect(DIRECTION)
	local info= TweenInfo.new(TIME_ANIMATION,Enum.EasingStyle.Quart,ease,REPEAT_TIME,IS_REVERSE,DELAY_TIME)
	local tween=tweenService:Create(PART,info,PROPERTY)

	tween:Play()
end

function module.linear(PART,TIME_ANIMATION,DIRECTION,REPEAT_TIME,IS_REVERSE,DELAY_TIME,PROPERTY)

	local ease=easingDirect(DIRECTION)
	local info= TweenInfo.new(TIME_ANIMATION,Enum.EasingStyle.Linear,ease,REPEAT_TIME,IS_REVERSE,DELAY_TIME)
	local tween=tweenService:Create(PART,info,PROPERTY)

	tween:Play()
end

function module.circular(PART,TIME_ANIMATION,DIRECTION,REPEAT_TIME,IS_REVERSE,DELAY_TIME,PROPERTY)

	local ease=easingDirect(DIRECTION)
	local info= TweenInfo.new(TIME_ANIMATION,Enum.EasingStyle.Circular,ease,REPEAT_TIME,IS_REVERSE,DELAY_TIME)
	local tween=tweenService:Create(PART,info,PROPERTY)

	tween:Play()
end

function module.exponential(PART,TIME_ANIMATION,DIRECTION,REPEAT_TIME,IS_REVERSE,DELAY_TIME,PROPERTY)

	local ease=easingDirect(DIRECTION)
	local info= TweenInfo.new(TIME_ANIMATION,Enum.EasingStyle.Exponential,ease,REPEAT_TIME,IS_REVERSE,DELAY_TIME)
	local tween=tweenService:Create(PART,info,PROPERTY)

	tween:Play()
end

return module
