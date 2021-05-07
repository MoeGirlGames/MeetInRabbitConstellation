package games.moegirl.rabbitconstellation.data.provider.base;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.IDataProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.apache.commons.lang3.text.translate.JavaUnicodeEscaper;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public abstract class ProviderSoundEvent implements IDataProvider {
    private static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().disableHtmlEscaping().create();
    private final Map<String, SoundEventData> data = new TreeMap<>();
    private DataGenerator gen;
    private ExistingFileHelper existingHelper;

    protected String modid;

    public ProviderSoundEvent(DataGenerator generator, String modidIn, ExistingFileHelper helper) {
        gen = generator;
        modid = modidIn;
        existingHelper = helper;
    }

    public abstract void addSounds();

    public void addSoundEvent() {

    }

    @Override
    public void act(DirectoryCache cache) throws IOException {
        addSounds();

        if (!data.isEmpty()) {
            save(cache, data, gen.getOutputFolder().resolve("assets/" + modid + "/sounds.json"));
        }
    }

    private void save(DirectoryCache cache, Map<String, SoundEventData> data, Path resolve) {

    }

    @Override
    public String getName() {
        return "SoundEvents";
    }
    
    public class SoundEventData {
        public String name;
        public boolean replace;
    }
}
