/*
 * -------------------------------------------------------------------------------------------------------
 * Class: PunchEffectCallable
 * This class is part of Metallurgy 4 Reforged
 * Complete source code is available at: https://github.com/Davoleo/Metallurgy-4-Reforged
 * This code is licensed under GNU GPLv3
 * Authors: ItHurtsLikeHell & Davoleo
 * Copyright (c) 2019.
 * --------------------------------------------------------------------------------------------------------
 */

package it.hurts.metallurgy_reforged.capabilities.punch;

import java.util.concurrent.Callable;

public class PunchEffectCallable implements Callable<PunchEffect> {

	@Override
	public PunchEffect call() throws Exception
	{
		return new PunchEffect();
	}

}
