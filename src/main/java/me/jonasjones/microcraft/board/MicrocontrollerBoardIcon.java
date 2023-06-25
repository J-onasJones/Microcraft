package me.jonasjones.microcraft.board;

import net.minecraft.resources.ResourceLocation;

public record MicrocontrollerBoardIcon(ResourceLocation boardTextureHorizontal, ResourceLocation boardTextureVertical,
                                       int width, int height) {
}