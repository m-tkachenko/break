package ua.salo.abreak.utils

import ua.salo.abreak.data.local.entity.BreakEntity
import ua.salo.abreak.domain.model.Break

object MappersUtil {
    fun Break.toEntity() =
        BreakEntity(
            name = name,
            content = content,
            timestamp = timestamp
        )

    fun BreakEntity.toModel() =
        Break(
            name = name,
            content = content,
            timestamp = timestamp
        )

    fun List<BreakEntity>.toListOfModels() = map {
            it.toModel()
        }
}