/*
 * -------------------------------------------------------------------------------------------------------
 * Class: ShadowIronArmorEffect
 * This class is part of Metallurgy 4 Reforged
 * Complete source code is available at: https://github.com/Davoleo/Metallurgy-4-Reforged
 * This code is licensed under GNU GPLv3
 * Authors: Davoleo, ItHurtsLikeHell, PierKnight100
 * Copyright (c) 2020.
 * --------------------------------------------------------------------------------------------------------
 */

package it.hurts.metallurgy_reforged.effect.effects;

import it.hurts.metallurgy_reforged.effect.AbstractMetallurgyEffect;
import it.hurts.metallurgy_reforged.material.ModMetals;
import it.hurts.metallurgy_reforged.model.EnumTools;
import it.hurts.metallurgy_reforged.util.EventUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;

import javax.annotation.Nullable;

public class ShadowIronArmorEffect extends AbstractMetallurgyEffect {

	public ShadowIronArmorEffect()
	{
		super(ModMetals.SHADOW_IRON);
	}

	@Override
	protected boolean isEnabled()
	{
		return true;
	}

	@Override
	protected boolean isToolEffect()
	{
		return false;
	}

	@Nullable
	@Override
	protected EnumTools getToolClass()
	{
		return null;
	}

	@Override
	public void onPlayerTick(EntityPlayer player)
	{
		if (EventUtils.isPlayerWearingArmor(player, metal) && player.isPotionActive(MobEffects.BLINDNESS))
		{
			player.removePotionEffect(MobEffects.BLINDNESS);
		}
	}

}
