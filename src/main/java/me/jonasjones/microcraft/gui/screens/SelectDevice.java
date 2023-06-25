package me.jonasjones.microcraft.gui.screens;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.logging.LogUtils;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.worldselection.CreateWorldScreen;
import net.minecraft.client.gui.screens.worldselection.SelectWorldScreen;
import net.minecraft.client.gui.screens.worldselection.WorldSelectionList;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.util.FormattedCharSequence;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

import java.util.List;
import java.util.function.Supplier;

@Environment(EnvType.CLIENT)
public class SelectDevice extends Screen {
    private static final Logger LOGGER = LogUtils.getLogger();
    protected final Screen parent;
    @Nullable
    private List<FormattedCharSequence> tooltip;
    private Button deleteButton;
    private Button selectButton;
    private Button editButton;
    private Button recreateButton;
    protected EditBox searchBox;
    private WorldSelectionList levelList;

    public SelectDevice(Screen parent) {
        super(Component.translatable("selectWorld.title"));
        this.parent = parent;
    }

    public boolean mouseScrolled(double mouseX, double mouseY, double amount) {
        return super.mouseScrolled(mouseX, mouseY, amount);
    }

    public void tick() {
        this.searchBox.tick();
    }

    protected void init() {
        //this.client.keyboard.setRepeatEvents(true);
        this.searchBox = new EditBox(this.font, this.width / 2 - 100, 22, 200, 20, this.searchBox, Component.translatable("selectWorld.search"));
        this.searchBox.setResponder((search) -> {
            //this.levelList.filter(search);
        });
        SelectWorldScreen uwu = new SelectWorldScreen(this);
        //this.levelList = new WorldListWidget(uwu, this.client, this.width, this.height, 48, this.height - 64, 36, this.getSearchFilter(), this.levelList);
        this.addWidget(this.searchBox);
        this.addWidget(this.levelList);
        this.selectButton = (Button)this.addRenderableWidget(Button.builder(Component.translatable("selectWorld.select"), (button) -> {
            this.levelList.getSelectedOpt().ifPresent(WorldSelectionList.WorldListEntry::joinWorld);
        }).bounds(this.width / 2 - 154, this.height - 52, 150, 20).build());
        this.addRenderableWidget(Button.builder(Component.translatable("selectWorld.create"), (button) -> {
            CreateWorldScreen.openFresh(this.minecraft, this);
        }).bounds(this.width / 2 + 4, this.height - 52, 150, 20).build());
        this.editButton = (Button)this.addRenderableWidget(Button.builder(Component.translatable("selectWorld.edit"), (button) -> {
            this.levelList.getSelectedOpt().ifPresent(WorldSelectionList.WorldListEntry::editWorld);
        }).bounds(this.width / 2 - 154, this.height - 28, 72, 20).build());
        this.deleteButton = (Button)this.addRenderableWidget(Button.builder(Component.translatable("selectWorld.delete"), (button) -> {
            this.levelList.getSelectedOpt().ifPresent(WorldSelectionList.WorldListEntry::deleteWorld);
        }).bounds(this.width / 2 - 76, this.height - 28, 72, 20).build());
        this.recreateButton = (Button)this.addRenderableWidget(Button.builder(Component.translatable("selectWorld.recreate"), (button) -> {
            this.levelList.getSelectedOpt().ifPresent(WorldSelectionList.WorldListEntry::recreateWorld);
        }).bounds(this.width / 2 + 4, this.height - 28, 72, 20).build());
        this.addRenderableWidget(Button.builder(CommonComponents.GUI_CANCEL, (button) -> {
            this.minecraft.setScreen(this.parent);
        }).bounds(this.width / 2 + 82, this.height - 28, 72, 20).build());
        this.worldSelected(false);
        this.setInitialFocus(this.searchBox);
    }

    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        return super.keyPressed(keyCode, scanCode, modifiers) ? true : this.searchBox.keyPressed(keyCode, scanCode, modifiers);
    }

    public void onClose() {
        this.minecraft.setScreen(this.parent);
    }

    public boolean charTyped(char chr, int modifiers) {
        return this.searchBox.charTyped(chr, modifiers);
    }

    public void render(PoseStack matrices, int mouseX, int mouseY, float delta) {
        this.tooltip = null;
        //this.levelList.render(matrices, mouseX, mouseY, delta);
        this.searchBox.render(matrices, mouseX, mouseY, delta);
        drawCenteredString(matrices, this.font, this.title, this.width / 2, 8, 16777215);
        super.render(matrices, mouseX, mouseY, delta);
        if (this.tooltip != null) {
            this.renderTooltip(matrices, this.tooltip, mouseX, mouseY);
        }

    }

    public void setTooltipForNextRenderPass(List<FormattedCharSequence> tooltip) {
        this.tooltip = tooltip;
    }

    public void worldSelected(boolean active) {
        this.selectButton.active = active;
        this.deleteButton.active = active;
        this.editButton.active = active;
        this.recreateButton.active = active;
    }

    public void removed() {
        if (this.levelList != null) {
            this.levelList.children().forEach(WorldSelectionList.Entry::close);
        }

    }

    public Supplier<String> getSearchFilter() {
        return () -> {
            return this.searchBox.getValue();
        };
    }
}
