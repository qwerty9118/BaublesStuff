/*
 * This class (Charm_Core.java) was created by <zazpro>. It's distributed as
 * part of the Baubles Stuff Mod. Get the Source Code in github:
 * https://github.com/ZAZPRO/BaublesStuff
 *
 * Baubles Stuff is Open Source and distributed under the
 * Baubles Stuff License: https://github.com/ZAZPRO/BaublesStuff/blob/master/LICENSE.MD
 *
 * © 2016 zazpro
 */

package md.zazpro.mod.common.baubles;

import baubles.api.BaubleType;
import md.zazpro.mod.common.baubles.base.BaubleBase;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

import static md.zazpro.mod.common.items.ItemsAndUpgrades.Charm_CoreVariants;

public class Charm_Core extends BaubleBase {

    public Charm_Core(String name) {
        super(name);
        setHasSubtypes(true);
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemStack) {
        return BaubleType.CHARM;
    }

    // This is a fun method which allows us to run some code when our item is
    // shown in a creative tab.
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs tab, List itemList) {
        for (int i = 0; i < Charm_CoreVariants.length; i++) {
            ItemStack itemStack = new ItemStack(item);
            itemStack.setTagCompound(new NBTTagCompound());
            itemStack.getTagCompound().setString("ItemModel", Charm_CoreVariants[i]);
            itemList.add(itemStack);
        }
    }

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (!stack.hasTagCompound()) {
            stack.setTagCompound(new NBTTagCompound());
            stack.getTagCompound().setString("ItemModel", Charm_CoreVariants[0]);
        }
    }
}