package me.efnilite.skematic.elements.effects;

import ch.njol.skript.classes.Changer;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.Variable;
import ch.njol.util.Kleenean;
import ch.njol.util.coll.CollectionUtils;
import org.bukkit.World;
import org.bukkit.event.Event;
import org.eclipse.jdt.annotation.Nullable;

public class EffDelAsyncWorld extends Effect {

    private Expression<World> world;
    private Expression<Variable> var;

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, SkriptParser.ParseResult parser) {
        var = (Expression<Variable>) exprs[0];
        world = (Expression<World>) exprs[0];
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        return "delete the async world " + world.toString(event, debug) + " stored in the variable " + var.toString(event, debug);
    }

    @Override
    protected void execute(Event e) {
        ((World) world).getWorldFolder().delete();
        var.change(e, CollectionUtils.array(world.getSingle(e)), Changer.ChangeMode.DELETE);
    }

}