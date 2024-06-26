package com.vk.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonDetailDTO(
    val abilities: List<AbilityItem>,
    @SerialName("base_experience") val baseExperience: Int,
    val cries: Cries,
    val forms: List<Forms>,
    @SerialName("game_indices") val gameIndices: List<GameIndex>,
    val height: Int,
    @SerialName("held_items") val heldItems: List<HeldItem>,
    val id: Int,
    @SerialName("is_default") val isDefault: Boolean,
    @SerialName("location_area_encounters") val locationAreaEncounters: String,
    val moves: List<Move>,
    val name: String,
    val order: Int,
    @SerialName("past_abilities") val pastAbilities: List<PastAbility>,
    @SerialName("past_types") val pastTypes: List<PastType>,
    val species: Species,
    val sprites: Sprites,
    val stats: List<Stats>,
    val types: List<Types>,
    val weight: Int,
)

@Serializable
data class AbilityItem(
    val ability: Ability,
    @SerialName("is_hidden") val isHidden: Boolean,
    val slot: Int,
)

@Serializable
data class Ability(
    val name: String,
    val url: String,
)

@Serializable
data class Cries(
    val latest: String,
    val legacy: String,
)

@Serializable
data class Forms(
    val name: String,
    val url: String,
)

@Serializable
data class GameIndex(
    @SerialName("game_index") val gameIndex: Int,
    val version: Version,
)

@Serializable
data class Version(
    val name: String,
    val url: String,
)

@Serializable
data class HeldItem(
    val item: Item,
    @SerialName("version_details") val versionDetails: List<VersionDetail>
)

@Serializable
data class Item(
    val name: String,
    val url: String,
)

@Serializable
data class VersionDetail(
    val rarity: Int,
    val version: Version,
)

@Serializable
data class Move(
    val move: MoveDetail,
    @SerialName("version_group_details") val versionGroupDetail: List<VersionGroupDetail>
)

@Serializable
data class MoveDetail(
    val name: String,
    val url: String,
)

@Serializable
data class VersionGroupDetail(
    @SerialName("level_learned_at") val levelLearnedAt: Int,
    @SerialName("move_learn_method") val moveLearnMethod: MoveLearnMethod,
    @SerialName("version_group") val versionGroup: VersionGroup,
)

@Serializable
data class MoveLearnMethod(
    val name: String,
    val url: String,
)

@Serializable
data class VersionGroup(
    val name: String,
    val url: String,
)

@Serializable
data class Species(
    val name: String,
    val url: String,
)

@Serializable
data class Sprites(
    @SerialName("back_default") val backDefault: String,
    @SerialName("back_female") val backFemale: String?,
    @SerialName("back_shiny") val backShiny: String,
    @SerialName("back_shiny_female") val backShinyFemale: String?,
    @SerialName("front_default") val frontDefault: String,
    @SerialName("front_female") val frontFemale: String?,
    @SerialName("front_shiny") val frontShiny: String,
    @SerialName("front_shiny_female") val frontShinyFemale: String?,
    val other: Other,
    val versions: Versions,
)

@Serializable
data class Other(
    @SerialName("dream_world") val dreamWorld: DreamWorld,
    val home: Home,
    @SerialName("official-artwork") val officialArtWork: OfficialArtWork,
    val showdown: Showdown,
)

@Serializable
data class DreamWorld(
    @SerialName("front_default") val frontDefault: String,
    @SerialName("front_female") val frontFemale: String?,
)

@Serializable
data class Home(
    @SerialName("front_default") val frontDefault: String,
    @SerialName("front_female") val frontFemale: String?,
    @SerialName("front_shiny") val frontShiny: String,
    @SerialName("front_shiny_female") val frontShinyFemale: String?,
)

@Serializable
data class OfficialArtWork(
    @SerialName("front_default") val frontDefault: String,
    @SerialName("front_shiny") val frontShiny: String,
)

@Serializable
data class Showdown(
    @SerialName("back_default") val backDefault: String,
    @SerialName("back_female") val backFemale: String?,
    @SerialName("back_shiny") val backShiny: String,
    @SerialName("back_shiny_female") val backShinyFemale: String?,
    @SerialName("front_default") val frontDefault: String,
    @SerialName("front_female") val frontFemale: String?,
    @SerialName("front_shiny") val frontShiny: String,
    @SerialName("front_shiny_female") val frontShinyFemale: String?,
)

@Serializable
data class Versions(
    @SerialName("generation-i") val generationI: GenerationI,
    @SerialName("generation-ii") val generationII: GenerationII,
    @SerialName("generation-iii") val generationIII: GenerationIII,
    @SerialName("generation-iv") val generationIV: GenerationIV,
    @SerialName("generation-v") val generationV: GenerationV,
    @SerialName("generation-vi") val generationVI: GenerationVI,
    @SerialName("generation-vii") val generationVII: GenerationVII,
    @SerialName("generation-viii") val generationVIII: GenerationVIII,
)

@Serializable
data class GenerationI(
    @SerialName("red-blue") val redBlue: RedBlue,
    val yellow: Yellow,
)

@Serializable
data class RedBlue(
    @SerialName("back_default") val backDefault: String,
    @SerialName("back_gray") val backGray: String,
    @SerialName("back_transparent") val backTransparent: String,
    @SerialName("front_default") val frontDefault: String,
    @SerialName("front_gray") val frontGray: String,
    @SerialName("front_transparent") val frontTransparent: String,
)

@Serializable
data class Yellow(
    @SerialName("back_default") val backDefault: String,
    @SerialName("back_gray") val backGray: String,
    @SerialName("back_transparent") val backTransparent: String,
    @SerialName("front_default") val frontDefault: String,
    @SerialName("front_gray") val frontGray: String,
    @SerialName("front_transparent") val frontTransparent: String,
)

@Serializable
data class GenerationII(
    val crystal: Crystal,
    val gold: Gold,
    val silver: Silver,
)

@Serializable
data class Crystal(
    @SerialName("back_default") val backDefault: String,
    @SerialName("back_shiny") val backShiny: String,
    @SerialName("back_shiny_transparent") val backShinyTransparent: String,
    @SerialName("back_transparent") val backTransparent: String,
    @SerialName("front_default") val frontDefault: String,
    @SerialName("front_shiny") val frontShiny: String,
    @SerialName("front_shiny_transparent") val frontShinyTransparent: String,
    @SerialName("front_transparent") val frontTransparent: String,
)

@Serializable
data class Gold(
    @SerialName("back_default") val backDefault: String,
    @SerialName("back_shiny") val backShiny: String,
    @SerialName("front_default") val frontDefault: String,
    @SerialName("front_shiny") val frontShiny: String,
    @SerialName("front_transparent") val frontTransparent: String,
)

@Serializable
data class Silver(
    @SerialName("back_default") val backDefault: String,
    @SerialName("back_shiny") val backShiny: String,
    @SerialName("front_default") val frontDefault: String,
    @SerialName("front_shiny") val frontShiny: String,
    @SerialName("front_transparent") val frontTransparent: String,
)

@Serializable
data class GenerationIII(
    val emerald: Emerald,
    @SerialName("firered-leafgreen") val fireredLeafgreen: FireredLeafgreen,
    @SerialName("ruby-sapphire") val rubySapphire: RubySapphire,
)

@Serializable
data class Emerald(
    @SerialName("front_default") val frontDefault: String,
    @SerialName("front_shiny") val frontShiny: String,
)

@Serializable
data class FireredLeafgreen(
    @SerialName("back_default") val backDefault: String,
    @SerialName("back_shiny") val backShiny: String,
    @SerialName("front_default") val frontDefault: String,
    @SerialName("front_shiny") val frontShiny: String,
)

@Serializable
data class RubySapphire(
    @SerialName("back_default") val backDefault: String,
    @SerialName("back_shiny") val backShiny: String,
    @SerialName("front_default") val frontDefault: String,
    @SerialName("front_shiny") val frontShiny: String,
)

@Serializable
data class GenerationIV(
    @SerialName("diamond-pearl") val diamondPearl: DiamondPearl,
    @SerialName("heartgold-soulsilver") val heartgoldSoulsilver: HeartSoulsilver,
    val platinum: Platinum,
)

@Serializable
data class DiamondPearl(
    @SerialName("back_default") val backDefault: String,
    @SerialName("back_female") val backFemale: String?,
    @SerialName("back_shiny") val backShiny: String,
    @SerialName("back_shiny_female") val backShinyFemale: String?,
    @SerialName("front_default") val frontDefault: String,
    @SerialName("front_female") val frontFemale: String?,
    @SerialName("front_shiny") val frontShiny: String,
    @SerialName("front_shiny_female") val frontShinyFemale: String?,
)

@Serializable
data class HeartSoulsilver(
    @SerialName("back_default") val backDefault: String,
    @SerialName("back_female") val backFemale: String?,
    @SerialName("back_shiny") val backShiny: String,
    @SerialName("back_shiny_female") val backShinyFemale: String?,
    @SerialName("front_default") val frontDefault: String,
    @SerialName("front_female") val frontFemale: String?,
    @SerialName("front_shiny") val frontShiny: String,
    @SerialName("front_shiny_female") val frontShinyFemale: String?,
)

@Serializable
data class Platinum(
    @SerialName("back_default") val backDefault: String,
    @SerialName("back_female") val backFemale: String?,
    @SerialName("back_shiny") val backShiny: String,
    @SerialName("back_shiny_female") val backShinyFemale: String?,
    @SerialName("front_default") val frontDefault: String,
    @SerialName("front_female") val frontFemale: String?,
    @SerialName("front_shiny") val frontShiny: String,
    @SerialName("front_shiny_female") val frontShinyFemale: String?,
)

@Serializable
data class GenerationV(
    @SerialName("black-white") val blackWhite: BlackWhite,
)

@Serializable
data class BlackWhite(
    val animated: Animated,
    @SerialName("back_default") val backDefault: String,
    @SerialName("back_female") val backFemale: String?,
    @SerialName("back_shiny") val backShiny: String,
    @SerialName("back_shiny_female") val backShinyFemale: String?,
    @SerialName("front_default") val frontDefault: String,
    @SerialName("front_female") val frontFemale: String?,
    @SerialName("front_shiny") val frontShiny: String,
    @SerialName("front_shiny_female") val frontShinyFemale: String?,
)

@Serializable
data class Animated(
    @SerialName("back_default") val backDefault: String,
    @SerialName("back_female") val backFemale: String?,
    @SerialName("back_shiny") val backShiny: String,
    @SerialName("back_shiny_female") val backShinyFemale: String?,
    @SerialName("front_default") val frontDefault: String,
    @SerialName("front_female") val frontFemale: String?,
    @SerialName("front_shiny") val frontShiny: String,
    @SerialName("front_shiny_female") val frontShinyFemale: String?,
)

@Serializable
data class GenerationVI(
    @SerialName("omegaruby-alphasapphire") val omegarubyAlphasapphire: OmegarubyAlphasapphire,
    @SerialName("x-y") val xY: XY,
)

@Serializable
data class OmegarubyAlphasapphire(
    @SerialName("front_default") val frontDefault: String,
    @SerialName("front_female") val frontFemale: String?,
    @SerialName("front_shiny") val frontShiny: String,
    @SerialName("front_shiny_female") val frontShinyFemale: String?,
)

@Serializable
data class XY(
    @SerialName("front_default") val frontDefault: String,
    @SerialName("front_female") val frontFemale: String?,
    @SerialName("front_shiny") val frontShiny: String,
    @SerialName("front_shiny_female") val frontShinyFemale: String?,
)

@Serializable
data class GenerationVII(
    @SerialName("icons") val icons: Icon,
    @SerialName("ultra-sun-ultra-moon") val ultraSunUltraMoon: UltraSunUltraMoon,
)

@Serializable
data class Icon(
    @SerialName("front_default") val frontDefault: String,
    @SerialName("front_female") val frontFemale: String?,
)

@Serializable
data class UltraSunUltraMoon(
    @SerialName("front_default") val frontDefault: String,
    @SerialName("front_female") val frontFemale: String?,
    @SerialName("front_shiny") val frontShiny: String,
    @SerialName("front_shiny_female") val frontShinyFemale: String?,
)

@Serializable
data class GenerationVIII(
    @SerialName("icons") val icons: Icon,
)

@Serializable
data class Stats(
    @SerialName("base_stat") val baseStat: Int,
    val effort: Int,
    val stat: Stat,
)

@Serializable
data class Stat(
    val name: String,
    val url: String,
)

@Serializable
data class Types(
    val slot: Int,
    val type: Type,
)

@Serializable
data class Type(
    val name: String,
    val url: String,
)

@Serializable
data class PastAbility(
    val abilities: List<AbilityItem>,
    val generation: Generation,
)

@Serializable
data class Generation(
    val name: String,
    val url: String,
)

@Serializable
data class PastType(
    val generation: Generation,
    val types: List<Types>,
)

