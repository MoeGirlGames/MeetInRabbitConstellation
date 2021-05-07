package games.moegirl.rabbitconstellation.sound;

import games.moegirl.rabbitconstellation.RabbitConstellation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, RabbitConstellation.MODID);

    public ModSounds(IEventBus bus) {
        RabbitConstellation.getInstance().getLogger().info("Registering items.");
        SOUNDS.register(bus);
    }

    public static RegistryObject<SoundEvent> FOR_RIVER = SOUNDS.register("for_river", () -> new SoundEvent(new ResourceLocation(RabbitConstellation.MODID, "for_river")));
}
