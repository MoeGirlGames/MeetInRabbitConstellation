package games.moegirl.rabbitconstellation.data.provider.base;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.IDataProvider;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.apache.commons.lang3.text.translate.JavaUnicodeEscaper;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

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

    public SoundEventDataSound simpleSound(String name) {
        SoundEventDataSound sound = new SoundEventDataSound();
        sound.name = modid + ":" + name;
        return sound;
    }

    public void addSoundEvents(SoundEvent sound, String subtitle, boolean replace, Object... sounds) {
        SoundEventData soundEventData = new SoundEventData();
        soundEventData.subtitle = subtitle;
        soundEventData.replace = replace;
        soundEventData.sounds.addAll(Arrays.asList(sounds));
        data.put(sound.getName().getPath(), soundEventData);
    }

    @Override
    public void act(DirectoryCache cache) throws IOException {
        addSounds();

        if (!data.isEmpty()) {
            save(cache, data, gen.getOutputFolder().resolve("assets/" + modid + "/sounds.json"));
        }
    }

    private void save(DirectoryCache cache, Map<String, SoundEventData> data, Path target) throws IOException {
        String str = GSON.toJson(data);
        String hash = IDataProvider.HASH_FUNCTION.hashUnencodedChars(str).toString();
        if (!Objects.equals(cache.getPreviousHash(target), hash) || !Files.exists(target)) {
            Files.createDirectories(target.getParent());

            try (BufferedWriter bufferedwriter = Files.newBufferedWriter(target)) {
                bufferedwriter.write(str);
            }
        }

        cache.recordHash(target, hash);
    }

    @Override
    public String getName() {
        return "SoundEvents";
    }
    
    public class SoundEventData {
        public String subtitle;
        public boolean replace;
        public List sounds = new ArrayList();
    }

    public class SoundEventDataSound {
        public String name;
        public float volume = 1.0f;
        public float pitch = 1.0f;
        public int weight = 1;
        public boolean stream = true;
        public int attenuation_distance = 16;
        public boolean preload = false;
        public String type = "file";
    }
}
