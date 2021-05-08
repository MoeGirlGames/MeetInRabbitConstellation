package games.moegirl.rabbitconstellation.data.provider.language;

import games.moegirl.rabbitconstellation.RabbitConstellation;
import games.moegirl.rabbitconstellation.data.provider.base.ProviderLanguage;
import games.moegirl.rabbitconstellation.item.ModItems;
import net.minecraft.data.DataGenerator;

public class LanguageZHCN extends ProviderLanguage {
    public LanguageZHCN(DataGenerator gen) {
        super(gen, RabbitConstellation.MODID, "zh_cn");
    }

    @Override
    protected void addTranslations() {
        addItemGroup("rabbit_constellation", "我们在兔子座上相遇");

        addItem(ModItems.MUSIC_DISC_FOR_RIVER, "音乐唱片");
        add("item.rabbitconstellation.music_disc_for_river.desc", "高瞰 - For River");
    }
}
