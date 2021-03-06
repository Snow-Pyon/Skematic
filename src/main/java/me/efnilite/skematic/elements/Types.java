package me.efnilite.skematic.elements;

import ch.njol.skript.classes.ClassInfo;
import ch.njol.skript.classes.Parser;
import ch.njol.skript.expressions.base.EventValueExpression;
import ch.njol.skript.lang.ParseContext;
import ch.njol.skript.registrations.Classes;
import ch.njol.skript.util.EnumUtils;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormat;
import com.sk89q.worldedit.regions.CuboidRegion;
import org.eclipse.jdt.annotation.Nullable;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Types {

    static {

        Classes.registerClass(new ClassInfo<>(File.class, "schematic")
                .user("schem(atic)6s?")
                .parser(new Parser<File>() {

                    @Override
                    public File parse(String s, ParseContext context) {
                        return new File(s);
                    }

                    @Override
                    public String toString(File o, int flags) {
                        return o.toString();
                    }

                    @Override
                    public String toVariableNameString(File o) {
                        return o.toString();
                    }

                    @Override
                    public String getVariableNamePattern() {
                        return "\\S+";
                    }
                }));

        Classes.registerClass(new ClassInfo<>(CuboidRegion.class, "cuboidregion")
                .user("cuboidregions?")
                .parser(new Parser<CuboidRegion>() {

                    @Override
                    public CuboidRegion parse(String s, ParseContext context) {
                        return null;
                    }

                    @Override
                    public String toString(CuboidRegion o, int flags) {
                        return null;
                    }

                    @Override
                    public String toVariableNameString(CuboidRegion o) {
                        return o.toString();
                    }

                    @Override
                    public String getVariableNamePattern() {
                        return "\\S+";
                    }
                }));

        final EnumUtils<ClipboardFormat> clipboardFormats = new EnumUtils<>(ClipboardFormat.class, "schematicformat");
        Classes.registerClass(new ClassInfo<>(ClipboardFormat.class, "schematicformat")
                .user("schematicformats?")
                .defaultExpression(new EventValueExpression<>(ClipboardFormat.class))
                .parser(new Parser<ClipboardFormat>() {

                    @Override
                    @Nullable
                    public ClipboardFormat parse(String s, ParseContext context) {
                        return clipboardFormats.parse(s);
                    }

                    @Override
                    public String toString(ClipboardFormat o, int flags) {
                        return clipboardFormats.toString(o, flags);
                    }

                    @Override
                    public String toVariableNameString(ClipboardFormat o) {
                        return o.name();
                    }

                    @Override
                    public String getVariableNamePattern() {
                        return "\\S+";
                    }

                }));
    }
}
