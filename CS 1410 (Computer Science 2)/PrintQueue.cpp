
class PrintQueue{
public:
	PrintJob* firstMember;
	PrintQueue(){
		firstMember = NULL;
	}	
	~PrintQueue(){
		delete firstMember;
	}
	void enqueue(std::string filename, int page){
		if (firstMember == NULL){
			firstMember = new PrintJob(filename, page);
		}
		else if (firstMember->next == NULL){
			if (firstMember->number > page){
				firstMember->next = new PrintJob(filename, page);
			}
			else{
				firstMember->next = new PrintJob(firstMember->filename, firstMember->number);
				firstMember->filename = filename;
				firstMember->number = page;
			}
		}
		else{
			if (page > firstMember->number){
				PrintJob* temp = firstMember->next;
				firstMember->next = new PrintJob(firstMember->filename, firstMember->number);
				firstMember->next->next = temp;
				firstMember->filename = filename;
				firstMember->number = page;
			}
			else{
				PrintJob* previous = firstMember;
				PrintJob* current = firstMember->next;
				while (current->next != NULL && page < current->number){
					previous = current;
					current = current->next;
				}
				if (current->next == NULL){
					if (page < current->number){
						current->next = new PrintJob(filename, page);
					}
					else{
						previous->next = new PrintJob(filename, page);
						previous->next->next = current;
					}
				}
				else{
					previous->next = new PrintJob(filename, page);
					previous->next->next = current;
				}
			}
		}
		}

	PrintJob* dequeue(){
		if (!isEmpty()){
			PrintJob* current = firstMember;
			PrintJob* previous = NULL;
			while (current->next != NULL){
				current = current->next;
				if (previous == NULL){
					previous = firstMember;
				}
				else{
					previous = previous->next;
				}
			}
			PrintJob* newJob = new PrintJob(current->filename, current->number);
			if (previous != NULL)
				previous->next = NULL;
			else
				firstMember = NULL;
			return newJob;
		}
		else{
			std::cout << "The queue is empty!";
		}
	}
	bool isEmpty(){
		if (firstMember == NULL)
			return true;
		else
			return false;
	}
};
