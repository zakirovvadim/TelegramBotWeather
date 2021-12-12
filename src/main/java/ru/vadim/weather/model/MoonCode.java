package ru.vadim.weather.model;

public enum MoonCode {
    FULL_MOON("полнолуние"),
    WANING_MOON("убывающая Луна"),
    LAST_QUARTER("последняя четверть"),
    NEW_MOON("новолуние"),
    THE_GROWING_MOON("растущая Луна"),
    FIRST_QUARTER("первая четверть");
    private  final String nameMoon;

    MoonCode(String nameMoon) {
        this.nameMoon = nameMoon;
    }

    public String getNameMoon() {
        return nameMoon;
    }
}
