package games.moegirl.rabbitconstellation.data.provider.base;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public abstract class ProviderLanguage extends LanguageProvider {
    protected String modid;

    public ProviderLanguage(DataGenerator gen, String modidIn, String locale) {
        super(gen, modidIn, locale);
        modid = modidIn;
    }

    public void addItemGroup(String id, String name) {
        add("itemGroup." + id, name);
    }
}
