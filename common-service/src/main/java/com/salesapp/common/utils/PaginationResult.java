package com.salesapp.common.utils;

import lombok.Data;
import org.hibernate.SQLQuery;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

@Data
public class PaginationResult<E> {
    /**
     * Tổng số bản ghi
     */
    private int totalRecords;
    /**
     * Trang hiện tại
     */
    private int currentPage;
    /**
     * Số bản ghi trên mỗi trang
     */
    private int maxResult;
    /**
     * Tổng số trang
     */
    private int totalPages;
    /**
     * Navigation page tối đa
     */
    private int maxNavigationPage;
    /**
     * List pages
     */
    private List<Integer> navigationPages;
    /**
     * List data
     */
    private List<E> data;

    /**
     * Pagination Result By Query
     *
     * @param query query
     * @param page  page
     */
    public PaginationResult(Query<E> query, int page, int maxResult, int maxNavigationPage) {
        List<E> results = new ArrayList<>();
        final int pageIndex = Math.max(page - 1, 0);
        int fromRecordIndex = pageIndex * maxResult;
        int maxRecordIndex = fromRecordIndex + maxResult;

        ScrollableResults resultScroll = query.scroll(ScrollMode.SCROLL_INSENSITIVE);
        boolean hasResult = resultScroll.first();
        if (hasResult) {
            // Scroll to position:
            hasResult = resultScroll.scroll(fromRecordIndex);
            if (hasResult) {
                do {
                    E record = (E) resultScroll.get(0);
                    results.add(record);
                } while (resultScroll.next() && resultScroll.getRowNumber() >= fromRecordIndex && resultScroll.getRowNumber() < maxRecordIndex);
            }
            // Go to Last record
            resultScroll.last();
        }

        // Total Records
        this.totalRecords = resultScroll.getRowNumber() + 1;
        this.currentPage = pageIndex + 1;
        this.data = results;
        this.maxResult = maxResult;
        this.totalPages = (totalRecords / maxResult) + ((totalRecords % maxResult != 0) ? 1 : 0);

        setMaxNavigationPage(maxNavigationPage);
        if (maxNavigationPage > totalPages) {
            this.maxNavigationPage = totalPages;
        }
        resultScroll.close();

        this.calculatorNavigationPages();
    }

    /**
     * Pagination Result By SQLQuery
     *
     * @param query query
     * @param page  page
     */
    public PaginationResult(SQLQuery<E> query, int page, int maxResult, int maxNavigationPage) {
        List<E> results = new ArrayList<>();
        final int pageIndex = Math.max(page - 1, 0);
        int fromRecordIndex = pageIndex * maxResult;
        int maxRecordIndex = fromRecordIndex + maxResult;

        ScrollableResults resultScroll = query.scroll(ScrollMode.SCROLL_INSENSITIVE);
        boolean hasResult = resultScroll.first();
        if (hasResult) {
            // Scroll to position:
            hasResult = resultScroll.scroll(fromRecordIndex);
            if (hasResult) {
                do {
                    E record = (E) resultScroll.get(0);
                    results.add(record);
                } while (resultScroll.next() && resultScroll.getRowNumber() >= fromRecordIndex && resultScroll.getRowNumber() < maxRecordIndex);
            }
            // Go to Last record
            resultScroll.last();
        }

        // Total Records
        this.totalRecords = resultScroll.getRowNumber() + 1;
        this.currentPage = pageIndex + 1;
        this.data = results;
        this.maxResult = maxResult;
        this.totalPages = (totalRecords / maxResult) + ((totalRecords % maxResult != 0) ? 1 : 0);

        setMaxNavigationPage(maxNavigationPage);
        if (maxNavigationPage > totalPages) {
            this.maxNavigationPage = totalPages;
        }

        resultScroll.close();

        this.calculatorNavigationPages();
    }

    private void calculatorNavigationPages() {
        this.navigationPages = new ArrayList<>();
        int current = Math.min(this.currentPage, this.totalPages);
        int begin = current - this.maxNavigationPage / 2;
        int end = current + this.maxNavigationPage / 2;

        // The first page
        navigationPages.add(1);
        if (begin > 2) {
            // Using for '...'
            navigationPages.add(-1);
        }

        for (int i = begin; i <= end; i++) {
            if (i > 1 && i < this.totalPages) {
                navigationPages.add(i);
            }
        }

        if (end <= this.totalPages - 2) {
            // Using for '...'
            navigationPages.add(-1);
        }

        if (totalPages > 1) {
            // The last page.
            navigationPages.add(this.totalPages);
        }
    }

}