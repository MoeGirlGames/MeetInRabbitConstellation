package games.moegirl.rabbitconstellation.data.provider;

import games.moegirl.rabbitconstellation.RabbitConstellation;
import games.moegirl.rabbitconstellation.data.provider.base.ProviderSoundEvent;
import games.moegirl.rabbitconstellation.sound.ModSounds;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ProviderSounds extends ProviderSoundEvent {
    public ProviderSounds(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, RabbitConstellation.MODID, helper);
    }

    @Override
    public void addSounds() {
        addSoundEvents(ModSounds.FOR_RIVER.get(), "for_river", false, simpleSound("for_river"));
    }
}
