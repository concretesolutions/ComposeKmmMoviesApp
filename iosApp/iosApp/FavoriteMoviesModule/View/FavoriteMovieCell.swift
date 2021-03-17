//
//  FavoriteMovieCell.swift
//  iosApp
//
//  Created by lucas.henrique.costa on 16/03/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI
import Kingfisher

struct FavoriteMovieCell: View {
    
    private let viewModel: MovieViewModelProtocol
    
    init(viewModel: MovieViewModelProtocol) {
        self.viewModel = viewModel
    }
        
    var body: some View {
        GeometryReader { reader in
            HStack(spacing: 15) {
                
                KFImage(viewModel.imageURL)
                    .resizable()
                    .frame(maxWidth: reader.size.width * 0.3)
                
                VStack {
                    HStack(alignment: .center) {
                        
                        Text(viewModel.title)
                            .font(.body)
                            .bold()
                        
                        Spacer()
                        
                        Text(String(viewModel.releaseYear))
                            .font(.footnote)
                    }
                    
                    Spacer()
                    
                    Text(viewModel.overview)
                        .multilineTextAlignment(.leading)
                        .lineLimit(3)
                        .font(.subheadline)
                }
                .padding([.top, .bottom, .trailing], 10)
            }
        }
    }
}

struct FavoriteMovieCell_Previews: PreviewProvider {
    
    static var previews: some View {
        FavoriteMovieCell(viewModel: MovieViewModelPreview())
            .previewLayout(.fixed(width: 300, height: 120))
    }
}
