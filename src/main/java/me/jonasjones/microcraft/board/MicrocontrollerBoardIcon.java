package me.jonasjones.microcraft.board;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.minecraft.util.Identifier;

public record MicrocontrollerBoardIcon(Identifier boardTextureHorizontal, Identifier boardTextureVertical, int width, int height) {}