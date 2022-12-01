package com.github.sandtechnology.fixds_store.resources;

public class ResourcePackDelegate implements net.minecraft.server.packs.PackResources {

    private final net.minecraft.server.packs.PackResources packResources;

    public ResourcePackDelegate(net.minecraft.server.packs.PackResources packResources) {
        this.packResources = packResources;
    }

    @Override
    @javax.annotation.Nullable
    public java.io.InputStream getRootResource(String p_10294_) throws java.io.IOException {
        return packResources.getRootResource(p_10294_);
    }

    @Override
    public java.io.InputStream getResource(net.minecraft.server.packs.PackType p_10289_, net.minecraft.resources.ResourceLocation p_10290_) throws java.io.IOException {
        return packResources.getResource(p_10289_, p_10290_);
    }

    @Override
    public java.util.Collection<net.minecraft.resources.ResourceLocation> getResources(net.minecraft.server.packs.PackType p_10284_, String p_10285_, String p_10286_, int p_10287_, java.util.function.Predicate<String> p_10288_) {
        return packResources.getResources(p_10284_, p_10285_, p_10286_, p_10287_, p_10288_);
    }

    @Override
    public boolean hasResource(net.minecraft.server.packs.PackType p_10292_, net.minecraft.resources.ResourceLocation p_10293_) {
        return packResources.hasResource(p_10292_, p_10293_);
    }

    @Override
    public java.util.Set<String> getNamespaces(net.minecraft.server.packs.PackType p_10283_) {
        java.util.Set<String> stringSet = new java.util.HashSet<>(packResources.getNamespaces(p_10283_));
        stringSet.remove(".DS_Store");
        return stringSet;
    }

    @Override
    @javax.annotation.Nullable
    public <T> T getMetadataSection(net.minecraft.server.packs.metadata.MetadataSectionSerializer<T> p_10291_) throws java.io.IOException {
        return packResources.getMetadataSection(p_10291_);
    }

    @Override
    public String getName() {
        return packResources.getName();
    }

    @Override
    public void close() {
        packResources.close();
    }

    @Override
    public boolean isHidden() {
        return packResources.isHidden();
    }
}
