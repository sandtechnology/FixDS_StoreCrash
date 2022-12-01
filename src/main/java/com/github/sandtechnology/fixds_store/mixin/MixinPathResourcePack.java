package com.github.sandtechnology.fixds_store.mixin;

@org.spongepowered.asm.mixin.Mixin(net.minecraftforge.resource.PathResourcePack.class)
public class MixinPathResourcePack {

    //Fixes from forge 1.19:
    @org.spongepowered.asm.mixin.injection.Redirect(method = "getResources",at = @org.spongepowered.asm.mixin.injection.At(value = "INVOKE", target = "Ljava/nio/file/Files;walk(Ljava/nio/file/Path;[Ljava/nio/file/FileVisitOption;)Ljava/util/stream/Stream;"))
    public java.util.stream.Stream<java.nio.file.Path> onGetResources(java.nio.file.Path start, java.nio.file.FileVisitOption[] options)
    {
        try {
            return java.nio.file.Files.walk(start,options).filter(java.nio.file.Files::isDirectory);
        } catch (java.io.IOException e) {
            return java.util.stream.Stream.empty();
        }
    }

}
