package games.moegirl.rabbitconstellation;

import games.moegirl.rabbitconstellation.item.ModItems;
import games.moegirl.rabbitconstellation.sound.ModSounds;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(RabbitConstellation.MODID)
public class RabbitConstellation {
    public static final String MODID = "rabbitconstellation";
    public static final String NAME = "Meet In Rabbit Constellation";

    private static RabbitConstellation INSTANCE;

    private final Logger logger = LogManager.getLogger(RabbitConstellation.NAME);

    public RabbitConstellation() {
        INSTANCE = this;

        final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::setup);

        new ModItems(bus);
        new ModSounds(bus);
    }

    private void setup(final FMLCommonSetupEvent event) {
        logger.info("We will meet in the Rabbit Constellation.");
    }

    public static RabbitConstellation getInstance() {
        return INSTANCE;
    }

    public Logger getLogger() {
        return logger;
    }
}
