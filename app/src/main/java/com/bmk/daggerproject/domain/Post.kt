package com.bmk.daggerproject.domain

import com.google.gson.annotations.SerializedName

/**
 * Created by manish on 07/07/201820.
 */
data class DataResponse(
    @field:SerializedName("Teams")
    val teams: Teams
)

data class Teams(

    @field:SerializedName("6")
    val jsonMember6: TeamInfo,

    @field:SerializedName("7")
    val jsonMember7: TeamInfo
)

data class TeamInfo(

    @field:SerializedName("Name_Short")
    val nameShort: String,

    @field:SerializedName("Name_Full")
    val nameFull: String,

    @field:SerializedName("Players")
    val players: Players
)

data class Players(

    @field:SerializedName("28891")
    val jsonMember28891: PlayersInfo,

    @field:SerializedName("12518")
    val jsonMember12518: PlayersInfo,

    @field:SerializedName("57458")
    val jsonMember57458: PlayersInfo,

    @field:SerializedName("64221")
    val jsonMember64221: PlayersInfo,

    @field:SerializedName("59736")
    val jsonMember59736: PlayersInfo,

    @field:SerializedName("48191")
    val jsonMember48191: PlayersInfo,

    @field:SerializedName("4356")
    val jsonMember4356: PlayersInfo,

    @field:SerializedName("5313")
    val jsonMember5313: PlayersInfo,

    @field:SerializedName("63611")
    val jsonMember63611: PlayersInfo,

    @field:SerializedName("3667")
    val jsonMember3667: PlayersInfo,

    @field:SerializedName("24669")
    val jsonMember24669: PlayersInfo,

    @field:SerializedName("2734")
    val jsonMember2734: PlayersInfo,

    @field:SerializedName("59429")
    val jsonMember59429: PlayersInfo,

    @field:SerializedName("64321")
    val jsonMember64321: PlayersInfo,

    @field:SerializedName("4038")
    val jsonMember4038: PlayersInfo,

    @field:SerializedName("64306")
    val jsonMember64306: PlayersInfo,

    @field:SerializedName("66833")
    val jsonMember66833: PlayersInfo,

    @field:SerializedName("3472")
    val jsonMember3472: PlayersInfo,

    @field:SerializedName("63084")
    val jsonMember63084: PlayersInfo,

    @field:SerializedName("57492")
    val jsonMember57492: PlayersInfo,

    @field:SerializedName("65739")
    val jsonMember65739: PlayersInfo,

    @field:SerializedName("64073")
    val jsonMember64073: PlayersInfo
)

data class PlayersInfo(

    @field:SerializedName("Bowling")
    val bowling: Bowling,

    @field:SerializedName("Position")
    val position: String,

    @field:SerializedName("Batting")
    val batting: Batting,

    @field:SerializedName("Name_Full")
    val nameFull: String
)

data class Bowling(

    @field:SerializedName("Economyrate")
    val economyrate: String,

    @field:SerializedName("Average")
    val average: String,

    @field:SerializedName("Style")
    val style: String,

    @field:SerializedName("Wickets")
    val wickets: String
)

data class Batting(

    @field:SerializedName("Strikerate")
    val strikerate: String,

    @field:SerializedName("Average")
    val average: String,

    @field:SerializedName("Style")
    val style: String,

    @field:SerializedName("Runs")
    val runs: String
)