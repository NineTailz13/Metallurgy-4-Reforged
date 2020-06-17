/*
 * -------------------------------------------------------------------------------------------------------
 * Class: QuicksilverArmorEffect
 * This class is part of Metallurgy 4 Reforged
 * Complete source code is available at: https://github.com/Davoleo/Metallurgy-4-Reforged
 * This code is licensed under GNU GPLv3
 * Authors: Davoleo, ItHurtsLikeHell, PierKnight100
 * Copyright (c) 2020.
 * --------------------------------------------------------------------------------------------------------
 */

package it.hurts.metallurgy_reforged.effect.effects;

import it.hurts.metallurgy_reforged.config.ArmorEffectsConfig;
import it.hurts.metallurgy_reforged.effect.AbstractMetallurgyEffect;
import it.hurts.metallurgy_reforged.material.ModMetals;
import it.hurts.metallurgy_reforged.model.EnumTools;
import it.hurts.metallurgy_reforged.util.EventUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;

import javax.annotation.Nullable;

public class QuicksilverArmorEffect extends AbstractMetallurgyEffect {

	public QuicksilverArmorEffect()
	{
		super(ModMetals.QUICKSILVER);
	}

	@Override
	protected boolean isEnabled()
	{
		return ArmorEffectsConfig.quicksilverArmorEffect;
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
	public void onPlayerUseItem(LivingEntityUseItemEvent event)
	{
		if (event.getEntityLiving() instanceof EntityPlayer)
		{
			EntityPlayer player = ((EntityPlayer) event.getEntityLiving());
			ItemStack stack = event.getItem();

			if (EventUtils.isPlayerWearingArmor(player, ModMetals.QUICKSILVER))
			{
				if (stack.getItem() instanceof ItemBow)
				{
					if (stack.getItem().getItemUseAction(stack) == EnumAction.BOW)
						event.setDuration(event.getDuration() - 6);
					else
						event.setDuration(Math.round(event.getDuration() / 2F));
				}
			}
		}
	}

}
