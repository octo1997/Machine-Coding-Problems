package com.Util;

import java.util.Date;
import java.util.Objects;

public class Slot implements Comparable<Slot>{
    private Date start, end;

    public Slot(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        Slot obj = (Slot)o;
        return this.start.getTime() == obj.getStart().getTime() &&
                this.end.getTime() == obj.getEnd().getTime();
    }

    @Override
    public int compareTo(Slot o) {
        long temp = this.start.getTime() - o.getStart().getTime();
        if(temp != 0) return temp > 0 ? 1 : -1;
        temp = this.end.getTime() - o.getEnd().getTime();
        if(temp != 0) return temp > 0 ? 1 : -1;
        return 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }
}
