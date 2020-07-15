package bookrental;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookManagementRepository extends PagingAndSortingRepository<BookManagement, Long>{


}