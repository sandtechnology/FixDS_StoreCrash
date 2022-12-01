package com.github.sandtechnology.fixds_store.mixin;

@org.spongepowered.asm.mixin.Mixin(net.minecraft.server.packs.resources.MultiPackResourceManager.class)
public class MixinMultiPackResourceManager {
    private final org.slf4j.Logger logger = com.mojang.logging.LogUtils.getLogger();
    @org.spongepowered.asm.mixin.Final
    @org.spongepowered.asm.mixin.Shadow
    private java.util.Map<String, net.minecraft.server.packs.resources.FallbackResourceManager> namespacedManagers;

    @org.spongepowered.asm.mixin.injection.Inject(method = "<init>", at = @org.spongepowered.asm.mixin.injection.At(value = "TAIL"))
    public void onInit(net.minecraft.server.packs.PackType p_203797_, java.util.List p_203798_, org.spongepowered.asm.mixin.injection.callback.CallbackInfo ci) {
        net.minecraft.server.packs.resources.FallbackResourceManager resourceManager = namespacedManagers.remove(".DS_Store");
        if (resourceManager != null) {
            logger.info("[Init] Removed .DS_Store namespace from MultiPackResourceManager!");
        }
    }
}
