public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.DoctorViewHolder> {

    private ArrayList<Doctor> doctorList;

    public DoctorAdapter(ArrayList<Doctor> doctorList) {
        this.doctorList = doctorList;
    }

    @NonNull
    @Override
    public DoctorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user_patient, parent, false);
        return new DoctorViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorViewHolder holder, int position) {
        Doctor doctor = doctorList.get(position);
        holder.nameTextView.setText("name = " + doctor.getName());
        holder.specialtyTextView.setText("specialty = " + doctor.getSpecialty());
        holder.emailTextView.setText("email = " + doctor.getEmail());
    }

    @Override
    public int getItemCount() {
        return doctorList.size();
    }

    public static class DoctorViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView specialtyTextView;
        TextView emailTextView;

        public DoctorViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            specialtyTextView = itemView.findViewById(R.id.specialtyTextView);
            emailTextView = itemView.findViewById(R.id.emailTextView);
        }
    }
}
