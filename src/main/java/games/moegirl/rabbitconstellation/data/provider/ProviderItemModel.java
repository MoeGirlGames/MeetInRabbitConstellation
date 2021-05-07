package games.moegirl.rabbitconstellation.data.provider;

import games.moegirl.rabbitconstellation.RabbitConstellation;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ProviderItemModel extends ItemModelProvider {
    public ProviderItemModel(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, RabbitConstellation.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

    }
}
