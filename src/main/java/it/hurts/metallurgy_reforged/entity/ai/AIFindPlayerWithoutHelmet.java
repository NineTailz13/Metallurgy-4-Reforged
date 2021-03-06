/*
 * -------------------------------------------------------------------------------------------------------
 * Class: AIFindPlayerWithoutHelmet
 * This class is part of Metallurgy 4 Reforged
 * Complete source code is available at: https://github.com/Davoleo/Metallurgy-4-Reforged
 * This code is licensed under GNU GPLv3
 * Authors: Davoleo, ItHurtsLikeHell, PierKnight100
 * Copyright (c) 2020.
 * --------------------------------------------------------------------------------------------------------
 */

package it.hurts.metallurgy_reforged.entity.ai;

import it.hurts.metallurgy_reforged.material.ModMetals;
import it.hurts.metallurgy_reforged.util.EventUtils;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;

import javax.annotation.Nullable;
import java.lang.reflect.Field;

public class AIFindPlayerWithoutHelmet extends EntityAIBase {

	private final EntityAIBase findplayerClass;

	public AIFindPlayerWithoutHelmet(EntityAIBase findplayerClass)
	{
		this.findplayerClass = findplayerClass;
	}


	//this method is identical to the original one but it checks if the player is wearing eximite armor
	@Override
	public boolean shouldExecute()
	{
		if (ModMetals.EXIMITE == null)
			return false;

		boolean shouldExecute = findplayerClass.shouldExecute();
		if (shouldExecute)
		{
			EntityPlayer player = getPlayer();
			shouldExecute = player != null && !EventUtils.isPlayerWearingArmor(player, ModMetals.EXIMITE);
		}
		return shouldExecute;
	}


	//this method is identical to the original one
	@Override
	public void resetTask()
	{
		findplayerClass.resetTask();
	}

	//this method is identical to the original one
	@Override
	public void startExecuting()
	{
		findplayerClass.startExecuting();
	}

	//this method is identical to the original one
	@Override
	public boolean shouldContinueExecuting()
	{
		return findplayerClass.shouldContinueExecuting();
	}

	//this method is identical to the original one
	@Override
	public void updateTask()
	{
		findplayerClass.updateTask();
	}


	//get the player from the original AI Classe
	@Nullable
	public EntityPlayer getPlayer()
	{
		try
		{
			Field aiClass = findplayerClass.getClass().getDeclaredField("player");
			aiClass.setAccessible(true);
			return (EntityPlayer) aiClass.get(findplayerClass);
		}
		catch (Exception e)
		{
			return null;
		}
	}

}
