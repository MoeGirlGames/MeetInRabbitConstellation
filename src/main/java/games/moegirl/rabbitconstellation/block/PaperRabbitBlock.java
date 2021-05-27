package games.moegirl.rabbitconstellation.block;


import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public class PaperRabbitBlock extends Block {
    public PaperRabbitBlock() {
        super(AbstractBlock.Properties.create(Material.WOOL, MaterialColor.WHITE_TERRACOTTA).notSolid().variableOpacity());
    }
}
