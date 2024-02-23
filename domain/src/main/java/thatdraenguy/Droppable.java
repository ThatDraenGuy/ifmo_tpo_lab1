package thatdraenguy;

public interface Droppable {
    public abstract void visit(DroppableVisitor visitor, int count);
}
