package games.moegirl.rabbitconstellation.data;

import games.moegirl.rabbitconstellation.RabbitConstellation;
import games.moegirl.rabbitconstellation.data.provider.ProviderItemModel;
import games.moegirl.rabbitconstellation.data.provider.language.LanguageZHCN;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = RabbitConstellation.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGen {
    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper helper = event.getExistingFileHelper();

        if (event.includeClient()) {
            generator.addProvider(new ProviderItemModel(generator, helper));
        }

        if (event.includeServer()) {
            generator.addProvider(new LanguageZHCN(generator));
        }
    }
}