package com.github.sandtechnology.fixds_store.mixin;

@org.spongepowered.asm.mixin.Mixin(net.minecraft.server.packs.resources.MultiPackResourceManager.class)
public class MixinMultiPackResourceManager {
    @org.spongepowered.asm.mixin.Final
    @org.spongepowered.asm.mixin.Shadow
    private java.util.Map<String, net.minecraft.server.packs.resources.FallbackResourceManager> namespacedManagers;

    private org.slf4j.Logger logger= com.mojang.logging.LogUtils.getLogger();
    @org.spongepowered.asm.mixin.injection.Inject(method = "getNamespaces", at = @org.spongepowered.asm.mixin.injection.At(value = "HEAD"))
    public void onGetResources(org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable<java.util.Set<String>> cir)
    {
        net.minecraft.server.packs.resources.FallbackResourceManager resourceManager=namespacedManagers.remove(".DS_Store");
        if(resourceManager!=null){
            logger.info("Removed .DS_Store namespace from MultiPackResourceManager!");
        }
    }
}
