package fontys.jpaqueries.mapper;

public interface GMapper<FROM,TO> {
   TO map (FROM from);
}