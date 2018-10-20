package ssp.scheduleplanner.model.rangeOfWeek;

import static ssp.scheduleplanner.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

/**
 * Represents a rangeOfWeek for the schedule planner.
 */
public class RangeOfWeek {

    private final String startOfWeekDate;
    private final String endOfWeekDate;
    private final String description;

    /**
     * Every field must be present and not null.
     */
    public RangeOfWeek(String startOfWeekDate, String endOfWeekDate, String description) {
        requireAllNonNull(startOfWeekDate, endOfWeekDate, description);
        this.startOfWeekDate = startOfWeekDate;
        this.endOfWeekDate = endOfWeekDate;
        this.description = description;
    }

    public String getStartOfWeekDate() {
        return startOfWeekDate;
    }

    public String getEndOfWeekDate() {
        return endOfWeekDate;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Returns true if both object have same fields.
     */
    public boolean isSameRangeOfWeek(RangeOfWeek otherRangeOfWeek) {
        if (otherRangeOfWeek == this) {
            return true;
        }

        return otherRangeOfWeek != null
                && otherRangeOfWeek.getStartOfWeekDate().equals(getStartOfWeekDate())
                && otherRangeOfWeek.getEndOfWeekDate().equals(getEndOfWeekDate())
                && otherRangeOfWeek.getDescription().equals(getDescription());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(startOfWeekDate, endOfWeekDate, description);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(" Start of Week: ")
                .append(getStartOfWeekDate())
                .append(" End of Week: ")
                .append(getEndOfWeekDate())
                .append(" Description: ");
        return builder.toString();
    }

}
